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
            <img src="/image/arrow-right-purple.png" alt="" />
        </div>
    )
}