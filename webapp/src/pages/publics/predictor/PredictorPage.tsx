import { useEffect, useState } from "react";
import { isAuthenticated } from "common/AuthenticationHelper"
import { useParams } from "react-router-dom";
import { FavoritesCryptos } from "models/FavoritesCryptos";
import HttpClient from "common/HttpClient";
import { PredictionData } from "models/PredictorData";
import { PulseLoader } from "react-spinners";
export default function PredicatorPage({ authenticationStatus }) {

    const [isAuthenticatedState, setIsAuthenticatedState] = useState(false);
    const { id } = useParams();
    const [crypto, setCrypto] = useState<PredictionData>(null)
    const [haveData, setHaveData] = useState<boolean>(false)
    let [loading, setLoading] = useState(true);
    let [color, setColor] = useState("#B2A4FF");

    const getCryptoById = async () => {
        const request = {
            cryptoId: Number.parseInt(id),
            currency: "USD"
        }
        const response = await HttpClient.post(`/predictor`, request);
        let responseTyped: PredictionData = await response.data.body;
        setCrypto(responseTyped)
        setLoading(false)
        setHaveData(true)
    }

    useEffect(() => {
        getCryptoById()
    }, [])

    useEffect(() => { setIsAuthenticatedState(isAuthenticated(authenticationStatus)) }, []);

    return (
        <>{!isAuthenticatedState
            ? <p>loader</p>
            : <div>
                {!haveData
                    ? <div className="currencies-page-sweet-loading">
                        <PulseLoader color={color} loading={loading} size={25} />
                    </div>
                    : <div>
                        <div>
                            {crypto.isBull ? <p>sube</p> : <p>baja</p>}
                            <img src={crypto.logo} alt="" />
                            <p>{crypto.price}</p>
                            <p>BOTON ME GUSTA</p>
                        </div>
                        <div>
                            <p>{crypto.volume_24h}</p>
                            <p>{crypto.volume_change_24h}</p>
                            <p>{crypto.percent_change_1h}</p>
                            <p>{crypto.percent_change_24h}</p>
                            <p>{crypto.percent_change_7d}</p>
                            <p>{crypto.percent_change_30d}</p>
                            <p>{crypto.percent_change_60d}</p>
                            <p>{crypto.percent_change_90d}</p>
                        </div>
                    </div>}
                </div>
        }
        </>
    )
}