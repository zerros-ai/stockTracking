import React, {useEffect, useState} from "react";
import axios from "axios";

export default function SearchBar({ onSelect }) {
    const [keyword, setKeyword] = useState("");
    const [results,setResults] = useState([]);

    useEffect(() => {
        if(keyword.trim() === ""){
            setResults([]);
            return;
        }
        const fetchData = async () => {
            try {
                const res = await axios.get(`http://localhost:8081/api/stock-info/getStockInfoByName`,{
                    params : { keyword }
                });
                setResults(res.data);
                console.log(res);
            }catch (err) {
                console.error(err);
                setResults([]);
            }

        };
        const delayDebounce = setTimeout(() => {
            fetchData();
        }, 300);
        return () => clearTimeout(delayDebounce);
    }, [keyword]);

    return (
        <div className="relative w-full max-w-md">
            <input
                type="text"
                className="w-full border rounded px-3 py-2"
                placeholder="종목명을 입력하세요"
                value={keyword}
                onChange={(e) => setKeyword(e.target.value)}
            />
            {results.length > 0 && (
                <ul className="absolute z-10 w-full bg-white border rounded mt-1 max-h-60 overflow-y-auto shadow">
                    {results.map((item, index) => (
                        <li
                            key={index}
                            onClick={() => {
                                onSelect(item); // 부모에 선택 전달
                                setKeyword(item.isuNm);
                                setResults([]);
                            }}
                            className="px-3 py-2 hover:bg-gray-100 cursor-pointer"
                        >
                            <span className="text-orange-600 font-semibold">{item.isuNm}</span> ({item.isuSrtCd})
                            · {item.mktTpNm}
                        </li>
                    ))}
                </ul>
            )}
        </div>
    )
}
