import { useContext, useEffect, useState } from "react";
import CryptoCurrencyContext from "../../../context/cryptoCurrencyContext/CryptoCurrencyContext";
import {CryptoRankedByCmc} from "../../../models/Models"
import "./TopFourCryptos.css"
import {PulseLoader,} from "react-spinners";
export const TopFourCryptos = ({authenticationStatus}) => {

    const {getCoinMarketCapListTop300} = useContext(CryptoCurrencyContext);

    let [loading, setLoading] = useState(true);
    let [color, setColor] = useState("#B2A4FF");
    const [topCoins, setTopCoins] = useState([]);

    const returningTopFourCryptos = async () => {
        await getCoinMarketCapListTop300();
        await getByLocalStorageTopCoins();
    }

    const getByLocalStorageTopCoins = async() =>{
        const topCoinsByLocalStorage = await JSON.parse(localStorage.getItem("topCoins"));
        setTopCoins(topCoinsByLocalStorage)
        setLoading(false)
    }

    useEffect(() => {
        if(!localStorage.getItem("topCoins")){
            returningTopFourCryptos();
        }
        else if (localStorage.getItem("topCoins")){
            getByLocalStorageTopCoins();
        }
    }, [localStorage.getItem("topCoins")])
    return(
        <>{
            !topCoins || topCoins.length === 0 ?
            <div>
                <PulseLoader color={color} loading={loading} size={25} />
            </div>:
            <div className={"top-four-list-base top-four-list-base-".concat(authenticationStatus)}>
            <div>
                <p>rank</p>
                <p>symbol</p>    
                <p>name</p>    
            </div>
            <ul className="">
                {topCoins.map(particular => (
                <li key={particular.id}>
                    <p>{particular.rank}</p>
                    <p>{particular.symbol}</p>    
                    <p>{particular.name}</p>    
                    
                </li>
                ))}
            </ul>
        </div>
        }</>
    )
}