import { configureStore } from '@reduxjs/toolkit';
import productsReducer from './ProductSlice';
import categoriesReducer from './CategorySlice'
import chefsReducer from './ChefSlice';


export const Store = configureStore({
    reducer: {
        products: productsReducer,
        categories:categoriesReducer,
        chefs:chefsReducer
    },

});

export type RootState = ReturnType<typeof Store.getState>;
export type AppDispatch = typeof Store.dispatch;