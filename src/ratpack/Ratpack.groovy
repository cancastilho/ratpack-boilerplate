import static ratpack.groovy.Groovy.ratpack
import ratpack.http.MutableHeaders
import static groovy.json.JsonOutput.toJson

def camada = [
    'POINT  ( 406478.16760000 7405352.64270000)',
    'POINT  ( 392640.39080000 7398148.68200000)',
    'POINT  ( 408955.82970000 7411829.95600000)',
    'POINT  ( 408440.10860000 7412058.66850000)',
    'POINT  ( 408456.13300000 7411523.30300000)',
    'POINT  ( 407087.44680000 7410630.96930000)',
    'POINT  ( 408865.58980000 7409915.14880000)',
    'POINT  ( 410005.80830000 7410957.10660000)',
    'POINT  ( 404719.37030000 7414050.43540000)'
]

ratpack {
    handlers{
        all { 
            MutableHeaders headers = response.headers
            headers.set('Access-Control-Allow-Origin', '*')
            headers.set('Access-Control-Allow-Headers', 'x-requested-with, origin, content-type, accept')
            next() 
        }
        get{
            render 'Hello World!';
        }
        get('pontos'){
            response.contentType("application/json")
            response.send(toJson(camada))
        }
    }
}