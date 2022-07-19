import { CoinMarketCapListTop300Response } from "../../models/CoinMarketCapListTop300Response";
import {GET_300_COINS} from "../types"

export default (state, action) => {
    const {payload, type} = action;

    switch(type){
        case GET_300_COINS:
            console.log(payload)
            let payloadTyped : CoinMarketCapListTop300Response = payload;
            let top300 = payloadTyped.data;
            let top4 = top300.slice(0,4);
            localStorage.setItem("allCoins", JSON.stringify(top300));
            localStorage.setItem("topCoins", JSON.stringify(top4));
            return {
                ...state,
                allCoins: top300,
                topCoins: top4,
            }
        default:
            return state;
    }
}