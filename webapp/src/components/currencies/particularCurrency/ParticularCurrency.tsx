import {useEffect, useState} from "react"
import { CoinMarketCapMapEntity } from "../../../models/CoinMarketCapMapEntity";
import "./ParticularCurrency.css"

export const ParticularCurrency = (particularCurrency : CoinMarketCapMapEntity) => {

    const [favorites, setFavorites] = useState<CoinMarketCapMapEntity>(null);

    const isFavoriteCrypto = () => {
        let favoritesLocalStorage : Array<CoinMarketCapMapEntity> = JSON.parse(localStorage.getItem("favoritesCryptos"));
        favoritesLocalStorage.find(storageCurrency => particularCurrency.symbol === storageCurrency.symbol)
    }

        

    useEffect(() => {

    },[])

    return(
        <div className="particular-currency-base" key={particularCurrency.id}>
            <p>{particularCurrency.rank}</p>
            <p>{particularCurrency.symbol}</p>    
            <p>{particularCurrency.name}</p>
            {/* <img src="/image/heart-red.png" alt="" />   
            <img src="" alt="" />     */}
        </div>
    )
} 