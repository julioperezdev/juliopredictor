import { Link } from "react-router-dom"
import { CoinMarketCapMapEntity } from "../../../models/CoinMarketCapMapEntity"
import "./ParticularCurrencyUnauthorized.css"

export const ParticularCurrencyUnauthorized = (particularCurrency : CoinMarketCapMapEntity) =>{
    return(
        <div 
        className="particular-currency-unauthorized-base" 
        key={particularCurrency.id}>
            <p>{particularCurrency.rank}</p>
            <p>{particularCurrency.symbol}</p>    
            <p>{particularCurrency.name}</p>
            <Link
            to={`/crypto/${particularCurrency.id}`}>
            <img 
            className="particular-currency-unauthorized-image" 
            src="/image/arrow-right-purple.png" alt="" />
            </Link>
        </div>
    )
}