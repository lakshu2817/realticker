import axios from "axios";

const BASE_URL = "http://localhost:8080/api/stocks";

export const getTopStocks = () => axios.get(`${BASE_URL}/top10`);

export const getHistory = (ticker) =>
  axios.get(`${BASE_URL}/${ticker}/history`);

export const analyzeStock = (ticker) =>
  axios.post(`${BASE_URL}/${ticker}/analyze`);