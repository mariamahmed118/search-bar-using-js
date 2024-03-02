const search = () => {
    const searchValue = document.getElementById("search_item").value.toUpperCase();
    const storeitems = document.getElementsByClassName("product-list")[0];
    const products = Array.from(document.querySelectorAll(".product"));
  
    let visibleCount = 0;
  
    products.forEach(product => {
      let match = product.querySelector('h2');
      if (match) {
        let textValue = match.textContent || match.innerHTML;
        if (textValue.toUpperCase().indexOf(searchValue) > -1) {
          visibleCount++;
        }
      }
    });
  
    products.forEach(product => {
      let match = product.querySelector('h2');
      if (match) {
        let textValue = match.textContent || match.innerHTML;
        if (textValue.toUpperCase().indexOf(searchValue) > -1) {
          product.style.display = "";
          if (visibleCount === 1) {
            product.style.marginBottom = "0";
          } else {
            product.style.marginBottom = "5px"; // قم بتعديل هذا الرقم حسب ما تحتاجه من مسافة
          }
        } else {
          product.style.display = "none";
        }
      }
    });
  };
  