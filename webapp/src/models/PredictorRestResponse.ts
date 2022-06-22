export interface PredictorRestResponse<bodyObject>{
    statusCode : number,
    status : string,
    message : string,
    body : bodyObject,
}