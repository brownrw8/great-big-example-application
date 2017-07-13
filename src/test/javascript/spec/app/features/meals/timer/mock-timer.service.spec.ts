import { Injectable } from '@angular/core';

import { TimerService } from '../../../../../../../main/webapp/app/features/meals/timer/timer.service';

@Injectable()
export class MockTimerService extends TimerService {
    constructor() {
        super(null, null);
    }
}