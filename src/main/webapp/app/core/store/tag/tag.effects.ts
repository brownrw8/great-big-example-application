import { Injectable } from '@angular/core';
import { Store } from '@ngrx/store';
import { Actions, Effect } from '@ngrx/effects';

import { slices } from '../util';
import { RESTService } from '../../services/rest.service';
import * as functions from '../slice/slice.functions';

@Injectable()
export class TagEffects {
    @Effect()
    private loadFromRemote$ = functions.loadFromRemote$(this.actions$, slices.TAG, this.dataService, 'getEntities');

    constructor(private actions$: Actions,
        private dataService: RESTService) { }
}
