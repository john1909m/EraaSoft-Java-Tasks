import { createSlice, createAsyncThunk } from "@reduxjs/toolkit";
import axios from "axios";
import type { RootState } from "./store";

export interface Chef {
  chefId: number;
  chefName: string;
  chefSpec: string;
  logoPath: string;
  facebookLink?: string;
  twitterLink?: string;
  instagramLink?: string;
}

export const fetchChefs = createAsyncThunk("chefs/fetchChefs",
   async () => {
      const response = await axios.get("http://localhost:8080/getChefs");
  return response.data as Chef[];
});

interface ChefState {
  list: Chef[];
  loading: boolean;
  error: string | null;
}

const initialState: ChefState = {
  list: [],
  loading: false,
  error: null,
};

const chefSlice = createSlice({
  name: "chefs",
  initialState,
  reducers: {},
  extraReducers: (builder) => {
    builder
      .addCase(fetchChefs.pending, (state) => {
        state.loading = true;
        state.error = null;
      })
      .addCase(fetchChefs.fulfilled, (state, action) => {
        state.loading = false;
        state.list = action.payload;
      })
      .addCase(fetchChefs.rejected, (state, action) => {
        state.loading = false;
        state.error = action.error.message || "Failed to load chefs";
      });
  },
});

export const selectChefs = (state: RootState) => state.chefs.list;
export const selectChefsLoading = (state: RootState) => state.chefs.loading;

export default chefSlice.reducer;

