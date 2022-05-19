import {CryptoRankedByCmc} from "../../../models/Models"
import "./TopFourCryptos.css"

export const TopFourCryptos = ({authenticationStatus}) => {

    const returningTopFourCryptos = () : Array<CryptoRankedByCmc> => {
        return [
            {id: 1,rank: 1,name: "Bitcoin", symbol: "BTC"},
            {id: 2,rank: 2,name: "Etherium", symbol: "ETH"},
            {id: 3,rank: 3,name: "Slow Love Potion", symbol: "SLP"},
            {id: 4,rank: 4,name: "Juliocoin", symbol: "JUC"}
        ];
    }

    return(
        <div className={"top-four-list-base top-four-list-base-".concat(authenticationStatus)}>
            <div>
                <p>rank</p>
                <p>symbol</p>    
                <p>name</p>    
            </div>
            <ul className="">
                {returningTopFourCryptos().map(particular => (
                <li>
                    <p>{particular.rank}</p>
                    <p>{particular.symbol}</p>    
                    <p>{particular.name}</p>    
                    
                </li>
                ))}
            </ul>
        </div>
    )
}