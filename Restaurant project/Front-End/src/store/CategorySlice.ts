import { createSlice, createAsyncThunk } from "@reduxjs/toolkit";
import axios from "axios";
import type { RootState } from "./store";
// import Category from './../components/Category/Category';

export interface CategoryType{
    id:number,
    categoryName:string,
    categoryLogo:string,
    categoryFlag:string

}

export const fetchCategories= createAsyncThunk(
    "categories/fetchCategories",
    async () => {
        const response=await axios.get(
            "http://localhost:8080/getCategories"
        );
        return response.data as CategoryType[];
    } 
);

interface CategoryState{
    list:CategoryType[];
    loading:boolean;
    error:string | null;
}

const initialState:CategoryState={
    list:[],
    loading:false,
    error:null
};

const categorySlice=createSlice({
    name:"categories",
    initialState,
    reducers:{},
    extraReducers:(builder) => {
        builder.addCase(fetchCategories.pending,
        (state) => {
            state.loading=true;
            state.error=null;
        })
        .addCase(fetchCategories.fulfilled,
            (state,action) => {
                state.loading=false;
                state.list=action.payload;
            })
        .addCase(fetchCategories.rejected,
            (state,action) => {
                state.loading=false;
                state.error=action.error.message || "Failed to load categories"
            });
    }, 
});

export const selectCategories=(state:RootState)=> state.categories.list;
export const selectLoading = (state: RootState) => state.categories.loading;

export default categorySlice.reducer;

