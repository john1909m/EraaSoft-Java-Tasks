import { createSlice, createAsyncThunk } from "@reduxjs/toolkit";
import axios from "axios";
import type { RootState } from "./store";
// import type { RootState } from "/Store";

export interface Product {
  productId: number;
  productName: string;
  productDescription: string;
  productPrice: number;
  productImagePath: string;
  categoryId: number;
}

export interface FetchProductsArgs {
  categoryId?: number;
  searchTerm?: string;
}

// export const fetchProducts = createAsyncThunk(
//   "products/fetchProducts",
//   async (categoryId?:number) => {
//     let url ="http://localhost:8080/getProducts"
//     if(categoryId){
//       url = `http://localhost:8080/getProducts/categoryId/$(categoryId)`;
//     }
//     const response = await axios.get(url);
//     return response.data as Product[];
//   }
// );

// export const fetchProducts = createAsyncThunk(
//   "products/fetchProducts",
//   async (categoryId?: number) => {
//     let url = "http://localhost:8080/getProducts";
//     if (categoryId && categoryId !== 1) {
//       url = `http://localhost:8080/getProducts/categoryId/${categoryId}`;
//     }
//     const response = await axios.get(url);
//     return response.data as Product[];
//   }
// );

export const fetchProducts = createAsyncThunk(
  "products/fetchProducts",
  async ({ categoryId, searchTerm }: FetchProductsArgs = {}) => {
    const trimmedSearch = searchTerm?.trim();
    let url = "http://localhost:8080/getProducts";

    if (trimmedSearch) {
      
      url = `http://localhost:8080/search/${encodeURIComponent(trimmedSearch)}`;
    } else if (categoryId && categoryId !== 1) {
      url = `http://localhost:8080/getProducts/categoryId/${categoryId}`;
    }

    const response = await axios.get(url);
    return response.data as Product[];
  }
);

interface ProductState {
  list: Product[];
  loading: boolean;
  error: string | null;
}

const initialState: ProductState = {
  list: [],
  loading: false,
  error: null,
};

const productSlice = createSlice({
  name: "products",
  initialState,
  reducers: {},
  extraReducers: (builder) => {
    builder
      .addCase(fetchProducts.pending, (state) => {
        state.loading = true;
        state.error = null;
      })
      .addCase(fetchProducts.fulfilled, (state, action) => {
        state.loading = false;
        state.list = action.payload;
      })
      .addCase(fetchProducts.rejected, (state, action) => {
        state.loading = false;
        state.error = action.error.message || "Failed to load products";
      });
  },
});

export const selectProducts = (state: RootState) => state.products.list;
export const selectLoading = (state: RootState) => state.products.loading;

export default productSlice.reducer;