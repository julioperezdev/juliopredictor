import "./EmailImput.css"

export const EmailImput = () =>{
    return(
        <div  className="email-input-state0-email">
            <input 
            className="email-input-state0"
            type="text" 
            placeholder="coloca el email"
            maxLength={40}/>
            <img src="image/arrow-right.png" alt="" />
        </div>
    )
}