import {Component, inject} from '@angular/core';
import {CommonModule} from '@angular/common';
import {Telegram} from '../telegram';
import {Observable, of} from 'rxjs';
import {WebSocketService} from '../services/websocket.service';
import {map} from "rxjs/operators";

@Component({
    selector: 'app-dsrm',
    imports: [CommonModule],
    templateUrl: './dsrm.component.html',
    styleUrls: ['./dsrm.component.css'],
    standalone: true
})
export class DsrmComponent {
    public telegrams$! : Observable<Telegram[]>;

    webSocketService = inject(WebSocketService);

    constructor() {
        let stompClient = this.webSocketService.connect();

        stompClient.connect({}, (frame: any) => {
            stompClient.subscribe('/dsrm/telegram', (data: any) => {
                console.log("Receiving data from socket");
                this.telegrams$ = of(JSON.parse(data.body));
            });
        });
    }
}