import React, { useEffect, useState } from "react";
import { getHistory, analyzeStock } from "../services/api";
import {
  LineChart,
  Line,
  XAxis,
  YAxis,
  Tooltip,
  CartesianGrid
} from "recharts";

export default function StockDetail({ ticker }) {
  const [history, setHistory] = useState([]);
    const [analysis, setAnalysis] = useState(null);
    const [loading, setLoading] = useState(false);

  useEffect(() => {
    if (ticker) {
      getHistory(ticker).then(res => setHistory(res.data));
    }
  }, [ticker]);
  const chartData = history.map((price, index) => ({
    day: index + 1,
    price: price
  }));

const handleAnalyze = async () => {
    setLoading(true);

    try {
      const res = await analyzeStock(ticker);

      let parsed;
      try {
        parsed =
          typeof res.data === "string"
            ? JSON.parse(res.data)
            : res.data;
      } catch {
        parsed = {
          trend: "-",
          risk: "-",
          suggestion: res.data
        };
      }

      setAnalysis(parsed);
    } catch (err) {
      setAnalysis({
        trend: "Error",
        risk: "-",
        suggestion: "Failed to fetch analysis"
      });
    }

    setLoading(false);
  };

  if (!ticker) return <p>Select a stock</p>;

  return (
    <div className="section">
      <h2>{ticker} Details</h2>

      {/* Chart */}
      <h3>Price History (6 Months)</h3>
      <LineChart width={600} height={300} data={chartData}>
        <CartesianGrid strokeDasharray="3 3" />
        <XAxis dataKey="day" />
        <YAxis />
        <Tooltip />
        <Line type="monotone" dataKey="price" />
      </LineChart>

      {/* Analyze Button */}
      <button onClick={handleAnalyze}>Analyze</button>

      {/* Loading */}
      {loading && <p>Analyzing...</p>}

      {/* Analysis Output */}
      {analysis && (
        <div className="analysis">
          <p><b>Trend:</b> {analysis.trend}</p>
          <p><b>Risk:</b> {analysis.risk}</p>
          <p><b>Suggestion:</b> {analysis.suggestion}</p>
        </div>
      )}

      {/* Disclaimer */}
      <p className="disclaimer">
        This is AI-generated analysis and not financial advice.
      </p>
    </div>
  );
}