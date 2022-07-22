import { useContext, useEffect, useState } from "react"
import CryptoCurrencyContext from "../../../context/cryptoCurrencyContext/CryptoCurrencyContext";
import {PulseLoader} from "react-spinners";
import {CurrenciesList} from "../../../components/currencies/currenciesList/CurrenciesList"

import "./CurrenciesPage.css"
import { CoinMarketCapMapEntity } from "../../../models/CoinMarketCapMapEntity";


export const CurrenciesPage = () =>{

    const [currencies, setCurrencies] = useState(null);
    let [loading, setLoading] = useState(true);
    let [color, setColor] = useState("#B2A4FF");

    const {getCoinMarketCapListTop300} = useContext(CryptoCurrencyContext);

    const renderCoinMarketCapListTop300 = async() =>{
        await getCoinMarketCapListTop300();
        const topCoinsByLocalStorage : Array<CoinMarketCapMapEntity> = await JSON.parse(localStorage.getItem("allCoins"));
        setCurrencies(topCoinsByLocalStorage);
        setLoading(false);
    }
    useEffect(() => {
        renderCoinMarketCapListTop300()

    }, [localStorage.getItem("allCoins")])

    return(
        <ul>
            {
            !currencies ? 
            <div className="currencies-page-sweet-loading">
                <PulseLoader color={color} loading={loading} size={25} />
            </div> :
            <div className="currencies-page-currencies-list">
                <CurrenciesList
                currencies={currencies}/>
            </div>
            }
        </ul>
    )
}