import { CoinMarketCapMapEntity } from "./CoinMarketCapMapEntity";
import { CoinMarketCapStatusResponse } from "./CoinMarketCapStatusResponse";

export interface CoinMarketCapListTop300Response{
    status : CoinMarketCapStatusResponse,
    data : Array<CoinMarketCapMapEntity>,
}