import React, { useEffect, useState } from "react";
import ReactApexChart from "react-apexcharts";
import axios from "axios";

export default function StockChart({ keyword }) {
    const [data, setData] = useState([]);
    const [range, setRange] = useState("1Y"); // 기본값: 1년

    useEffect(() => {
        if (!keyword) return;

        const today = new Date();
        const getStartDate = (range) => {
            const date = new Date(today);
            switch (range) {
                case "1M": date.setMonth(date.getMonth() - 1); break;
                case "3M": date.setMonth(date.getMonth() - 3); break;
                case "6M": date.setMonth(date.getMonth() - 6); break;
                case "1Y": default: date.setFullYear(date.getFullYear() - 1); break;
            }
            return date.toISOString().slice(0, 10).replace(/-/g, ""); // YYYYMMDD
        };

        const fetchData = async () => {
            const basDd = getStartDate(range);
            try {
                const res = await axios.get("http://localhost:8081/api/stock-info/getStockPriceByIsuSrtCd", {
                    params: { keyword: keyword, basDd }
                });
                console.log("res.data:", res.data);
                // 변환: [{ basDd, open, high, low, close }] => [{ x: '날짜', y: [open, high, low, close] }]
                const transformed = res.data.map(item => ({
                    x: item.basDd,
                    y: [item.tddOpnprc, item.tddHgprc, item.tddLwprc, item.tddClsprc]
                }));

                setData(transformed);
            } catch (err) {
                console.error(err);
            }
        };

        fetchData();
    }, [keyword, range]);

    const chartOptions = {
        chart: {
            type: 'candlestick',
            height: 500,
            toolbar: { show: false }
        },
        title: {
            text: `${keyword} 캔들 차트`,
            align: 'left'
        },
        xaxis: {
            type: 'category',
            labels: {
                rotate: -45
            }
        },
        yaxis: {
            tooltip: {
                enabled: true
            }
        }
    };

    return (
        <div className="p-4 rounded-2xl shadow-md bg-white w-full">
            <div className="flex justify-between items-center mb-4">
                <h2 className="text-lg font-bold">{keyword} 캔들 차트</h2>
                <div className="flex gap-2">
                    {[
                        { label: "1개월", value: "1M" },
                        { label: "3개월", value: "3M" },
                        { label: "6개월", value: "6M" },
                        { label: "1년", value: "1Y" },
                    ].map((btn) => (
                        <button
                            key={btn.value}
                            onClick={() => setRange(btn.value)}
                            className={`px-3 py-1 text-sm rounded-full border ${
                                range === btn.value ? "bg-blue-600 text-white" : "bg-white text-blue-600"
                            }`}
                        >
                            {btn.label}
                        </button>
                    ))}
                </div>
            </div>

            <ReactApexChart
                options={chartOptions}
                series={[{ data }]}
                type="candlestick"
                height={500}
            />
        </div>
    );
}
