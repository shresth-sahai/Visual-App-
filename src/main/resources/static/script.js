document.addEventListener("DOMContentLoaded", function(){
  fetch('http://localhost:8080/api/products')
  .then(response => response.json())
  .then(products =>{
    const tableBody=document.querySelector("#product-table tbody");
    products.forEach(products => {
      const row =document.createElement('tr');
      row.innerHTML = `
        <td> ${product.id} </td>
          <td> ${product.name} </td>
            <td> ${product.price} </td>
      `;
      tableBody.appendChild(row);
    })
  })
})