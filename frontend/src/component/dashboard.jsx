import React, {useState} from "react";
import SearchBar from "./SearchBar";
import StockChart from "./stockChart";

export default function DashBoard(){
    const [keyword,setKeyword] = useState("");
    const [selected, setSelected] = useState(null);
    return (
        <div className="min-h-screen bg-gray-100 py-10 px-4">
            <div className="max-w-4xl mx-auto">
                <h1 className="text-4xl font-bold text-center mb-10">📊 주식 데이터 대시보드</h1>

                {/* 검색창 */}
                <div className="mb-6">
                    <SearchBar onSelect={(item) => setSelected(item)}/>
                </div>

                {/* 종목 정보 */}
                {selected && (
                    <div className="bg-white p-6 rounded-xl shadow-md mb-6">
                        <h2 className="text-2xl font-semibold mb-2">{selected.isuNm}</h2>
                        <div className="text-sm text-gray-700">
                            <p><strong>종목 코드:</strong> {selected.isuSrtCd}</p>
                            <p><strong>상장 주식수:</strong> {selected.listShrs.toLocaleString()}</p>
                        </div>
                    </div>
                )}

                {/* 차트 */}
                {selected && (
                    <div className="bg-white p-6 rounded-xl shadow-md">
                        <StockChart keyword={selected.isuSrtCd}/>
                    </div>
                )}
            </div>
        </div>

    );
}