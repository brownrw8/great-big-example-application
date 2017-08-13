import { SliceAction } from '../slice/slice.actions';
import { Article } from './article.model';
import { slices } from '../util';

export const actions = {
    FAVORITE: 'FAVORITE',
    FAVORITE_SUCCESS: 'FAVORITE_SUCCESS',
    FAVORITE_FAIL: 'FAVORITE_FAIL',
    UNFAVORITE: 'UNFAVORITE',
    UNFAVORITE_SUCCESS: 'UNFAVORITE_SUCCESS',
    UNFAVORITE_FAIL: 'UNFAVORITE_FAIL'
}

class ArticleAction extends SliceAction {
    constructor(obj = {}) {
        super(slices.ARTICLE, obj);
    }
}

export class Favorite extends ArticleAction {
    protected actionName: string = actions.FAVORITE;
    constructor(slug: string) {
        super({ route: '/articles/' + slug + '/favorite' });
    }
}

export class FavoriteSuccess extends ArticleAction {
    protected actionName: string = actions.FAVORITE_SUCCESS;
}

export class FavoriteFail extends ArticleAction {
    protected actionName: string = actions.FAVORITE_FAIL;
}

export class Unfavorite extends ArticleAction {
    protected actionName: string = actions.UNFAVORITE;
}

export class UnfavoriteSuccess extends ArticleAction {
    protected actionName: string = actions.UNFAVORITE_SUCCESS;
}

export class UnfavoriteFail extends ArticleAction {
    protected actionName: string = actions.UNFAVORITE_FAIL;
}
