import { useEffect, useState } from "react"
import { CoinMarketCapMapEntity } from "../../../models/CoinMarketCapMapEntity"
import {ParticularCurrency} from "../particularCurrency/ParticularCurrency"

export const CurrenciesList = ({currencies}) => {

    const [currenciesConverted, setCurrenciesConverted] = useState<Array<CoinMarketCapMapEntity>>([]);

    const converPropToCoinMarketCapMapEntity = () => {
        let currenciesVariables : Array<CoinMarketCapMapEntity> = currencies;
        setCurrenciesConverted(currenciesVariables);
    }

    useEffect(() =>{converPropToCoinMarketCapMapEntity()},[])

    return(
        <ul>
            {currenciesConverted.map(particularCurrency => (
                <ParticularCurrency
                key={particularCurrency.id}
                {...particularCurrency}/>
            ))}
        </ul>
    )
}