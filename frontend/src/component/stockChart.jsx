import React, { useEffect, useState } from "react";
import {
    LineChart, Line, XAxis, YAxis, CartesianGrid, Tooltip, Legend, ResponsiveContainer
} from "recharts";
import axios from "axios";

export default function StockChart({ keyword }) {
    const [data, setData] = useState([]);

    useEffect(() => {
        if (!keyword) return;
        axios.get(`http://localhost:8081/api/stock-info/getStockInfoByName/${keyword}`)
            .then(res => setData(res.data))
            .catch(err => console.error(err));
    }, [keyword]);

    return (
        <div className="p-4 rounded-2xl shadow-md bg-white w-full h-[400px]">
            <h2 className="text-lg font-bold mb-2">{keyword.keyword} 종가 차트</h2>
            <ResponsiveContainer width="100%" height="90%">
                <LineChart
                    data={data}
                    margin={{ top: 10, right: 30, left: 0, bottom: 0 }}
                >
                    <CartesianGrid strokeDasharray="3 3" />
                    <XAxis dataKey="basDd" />
                    <YAxis domain={["auto", "auto"]} />
                    <Tooltip />
                    <Legend />
                    <Line type="monotone" dataKey="tddClsprc" stroke="#8884d8" strokeWidth={2} />
                </LineChart>
            </ResponsiveContainer>
        </div>
    );
}
