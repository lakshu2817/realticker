import React, { useEffect, useState } from "react";
import { getTopStocks } from "../services/api";

export default function StockTable({ onSelect }) {
  const [stocks, setStocks] = useState([]);

  useEffect(() => {
    getTopStocks().then(res => setStocks(res.data));
  }, []);

  return (
    <div>
      <h2>Top Stocks</h2>
      <table border="1">
        <thead>
          <tr>
            <th>Ticker</th>
            <th>Company</th>
            <th>Price</th>
            <th>Change %</th>
            <th>Volume</th>
          </tr>
        </thead>
        <tbody>
          {stocks.map(stock => (
            <tr key={stock.ticker} onClick={() => onSelect(stock.ticker)}>
              <td>{stock.ticker}</td>
              <td>{stock.company}</td>
              <td>{stock.price}</td>
              <td>{stock.changePercent}%</td>
              <td>{stock.volume}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}