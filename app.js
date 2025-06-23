fetch("http://localhost:8080/api/productos")
  .then(res => res.json())
  .then(data => {
    console.log(data);
    // acá podés mostrar los productos en tu página
  });