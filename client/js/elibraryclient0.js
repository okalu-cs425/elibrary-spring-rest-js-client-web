/**
 * @filename elibraryclient.js
 * @author O. Kalu
 * @since 2019-08-03
 */
(function() {
    function getBooks() {
      const xhr = new XMLHttpRequest();
      const url = 'https://jsonplaceholder.typicode.com/posts';
      xhr.open('GET', url);
      xhr.send();
  
      xhr.onreadystatechange = e => {
        if (xhr.readyState === XMLHttpRequest.DONE) {
          if (xhr.status === 200) {
            const divMainContainer = document.querySelector('#divMainContainer');
            divMainContainer.textContent = xhr.responseText;
          }
        }
      };
    }
    const lnkGetBooks = document.querySelector('#lnkGetBooks');
    lnkGetBooks.addEventListener('click', getBooks);
  })();