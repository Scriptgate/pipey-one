import {Component, inject} from '@angular/core';
import {CommonModule} from '@angular/common';
import {Telegram} from '../telegram';
import {Observable, of} from 'rxjs';
import {WebSocketService} from '../services/websocket.service';
import {map} from "rxjs/operators";
import Chart from 'chart.js/auto';

@Component({
    selector: 'app-dsrm',
    imports: [CommonModule],
    templateUrl: './dsrm.component.html',
    styleUrls: ['./dsrm.component.css'],
    standalone: true
})
export class DsrmComponent {
    public telegrams$ : Observable<Telegram[]> = of([]);
    public chart: any;

    webSocketService = inject(WebSocketService);

    constructor() {
        let stompClient = this.webSocketService.connect();

        stompClient.connect({}, (frame: any) => {
            stompClient.subscribe('/dsrm/telegram', (data: any) => {
                console.log("Receiving data from socket");
                let telegrams: Telegram[] = JSON.parse(data.body);
                this.telegrams$ = of(telegrams);
                if(this.chart) {
                    this.chart.destroy();
                }
                this.chart = new Chart("MyChart", {
                    type: 'line',
                    data: {
                        labels: telegrams.map(telegram => telegram.timestamp),
                        datasets: [
                            {
                                label: "L1 consumption",
                                data: telegrams.map(telegram => telegram.l1Consumption),
                                backgroundColor: 'red'
                            },
                            {
                                label: "L2 consumption",
                                data: telegrams.map(telegram => telegram.l2Consumption),
                                backgroundColor: 'blue'
                            },
                            {
                                label: "L3 consumption)",
                                data: telegrams.map(telegram => telegram.l3Consumption),
                                backgroundColor: 'limegreen'
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