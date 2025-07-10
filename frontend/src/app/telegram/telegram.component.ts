import {Component, inject} from '@angular/core';
import {CommonModule} from '@angular/common';
import {Telegram} from '../telegram';
import {Observable, of} from 'rxjs';
import {WebSocketService} from '../services/websocket.service';
import {map} from "rxjs/operators";
import Chart from 'chart.js/auto';

@Component({
    selector: 'app-telegram',
    imports: [CommonModule],
    templateUrl: './telegram.component.html',
    styleUrls: ['./telegram.component.css'],
    standalone: true
})
export class TelegramComponent {
    public telegrams$ : Observable<Telegram[]> = of([]);
    public totalConsumptionRateChart: any;
    public l1ConsumptionChart: any;

    webSocketService = inject(WebSocketService);

    constructor() {
        let stompClient = this.webSocketService.connect();

        stompClient.connect({}, (frame: any) => {
            stompClient.subscribe('/p1/telegram', (data: any) => {
                console.log("Receiving data from socket");
                let telegrams: Telegram[] = JSON.parse(data.body);
                this.telegrams$ = of(telegrams);
                if(this.totalConsumptionRateChart) {
                    this.totalConsumptionRateChart.destroy();
                }
                this.totalConsumptionRateChart = new Chart("TotalConsumptionRate", {
                    type: 'line',
                    data: {
                        labels: telegrams.map(telegram => telegram.timestamp),
                        datasets: [
                            {
                                label: "Total Consumption Day Rate",
                                data: telegrams.map(telegram => telegram.totalConsumptionDayRate),
                                backgroundColor: 'yellow'
                            },
                            {
                                label: "Total Consumption Night Rate",
                                data: telegrams.map(telegram => telegram.totalConsumptionNightRate),
                                backgroundColor: 'grey'
                            }
                        ]
                    },
                    options: {
                        aspectRatio: 2.5,
                        animation: {
                            duration: 0
                        }
                    }
                });
                if(this.l1ConsumptionChart) {
                    this.l1ConsumptionChart.destroy();
                }
                this.l1ConsumptionChart = new Chart("l1Consumption", {
                    type: 'line',
                    data: {
                        labels: telegrams.map(telegram => telegram.timestamp),
                        datasets: [
                            {
                                label: "L1 consumption",
                                data: telegrams.map(telegram => telegram.l1Consumption),
                                backgroundColor: 'red'
                            }
                        ]
                    },
                    options: {
                        aspectRatio: 2.5,
                        animation: {
                            duration: 0
                        }
                    }
                });
            });
        });
    }
}