import { useEffect, useState } from "react"
import Swal from "sweetalert2"
import { useNavigate } from "react-router-dom";

export default function AlertEmptyCryptoList() {
    const navigate = useNavigate()
    const [hasConfirmed, setHasConfirmed] = useState<boolean>(false);

    const alertFunction = async () =>{
        await Swal.fire({
            icon: 'warning',
            title: 'Detectamos que no tienes criptos seleccionados',
            text: 'puedes volver a la lista del top 300',
            confirmButtonColor: '#3085d6',
            confirmButtonText: 'cryptos',
            }).then((result) =>{
                if(result.isConfirmed){
                    setHasConfirmed(true);
                }
            })
    }

    useEffect(() => {
        alertFunction()
    },[])

    return(
        <>{hasConfirmed ? <>{navigate('/crypto')}</> : <></>}</>
    )
}