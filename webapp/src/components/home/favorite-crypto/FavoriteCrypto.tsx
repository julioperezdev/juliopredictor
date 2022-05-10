import "./FavoriteCrypto.css"

export const FavoriteCrypto = ({authenticationStatus}) =>{
    return(
        <div>
            {(() => {
                switch(authenticationStatus){
                case 0:
                    return <>
                    <div>
                        sin authenticacion
                    </div>
                    </>    

                case 1:
                    return <>
                    <div>
                        falta validacion
                    </div>
                    </>
                case 2:
                    return <>
                    <div>
                        falta validacion
                    </div>
                    </>
                }})()}
        </div>
    )
}