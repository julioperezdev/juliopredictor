import {CryptoRankedByCmc} from "../../../models/Models"
import "./CryptoList.css"

export const CryptoList = ({favoriteCryptosByUser}) =>{
    
    const favoriteCryptos: Array<CryptoRankedByCmc> = favoriteCryptosByUser;
    return (
        <div className="crypto-list-base">
            <div>
                <p>rank</p>
                <p>symbol</p>    
                <p>name</p>    
            </div>
            <ul className="crypto-list-ul">
                {favoriteCryptos.map(particular => (
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