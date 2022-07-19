import mem from "mem"
import HttpClient from "./HttpClient"

const refreshTokenFn = async () => {
    try {
        //let session : string = JSON.parse(localStorage.getItem("refreshToken"));
        let refreshToken : string = JSON.parse(localStorage.getItem("refreshToken"));
        const response = await HttpClient.post("/user/refresh", {
        refreshToken: refreshToken,
      });
  
      const { session } = response.data;
  
      if (!session?.accessToken) {
        localStorage.removeItem("session");
        localStorage.removeItem("user");
      }
  
      localStorage.setItem("session", JSON.stringify(session));
  
      return session;
    } catch (error) {
      localStorage.removeItem("session");
      localStorage.removeItem("user");
    }
  };
  
  const maxAge = 10000;
  
  export const memoizedRefreshToken = mem(refreshTokenFn, {
    maxAge,
  });