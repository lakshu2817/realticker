import React, { useState } from "react";
import StockTable from "./components/StockTable";
import StockDetail from "./components/StockDetail";
import css from "./App.css";

function App() {
  const [selectedTicker, setSelectedTicker] = useState(null);

  return (
    <div className="app-container">
      <h1>RealTicker</h1>

      <StockTable onSelect={setSelectedTicker} />

      <hr />

      <StockDetail ticker={selectedTicker} />
    </div>
  );
}

export default App;