class Request {

    async get(url){
        const res = await fetch(url);
        return res.json();
    }

    delete(url) {
        return fetch(url, {
          method: "DELETE",
          headers: {'Content-Type': 'application/json'}
        })
      } 
    


}

export default Request;
