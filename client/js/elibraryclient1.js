/**
 * @filename elibraryclient.js
 * @author O. Kalu
 * @since 2019-08-03
 * @lastmodified 2019-10-11
 */
(function() {
    function getBooks() {
      fetch('http://localhost:8080/elibrary/api/book/list')
      .then((response) => {
          if(response.ok) {    
            return response.json();
          } else {
            return Promise.reject({ status: response.status, statusText: response.statusText });
          }
        })
      .then(books => {
          let content = '<div><span style="font-size: 2em; color: #32a5e7;">Books in our Collection</span></div>';
          // content += '<p>&nbsp;</p>';         
          content += '<div id="divBooksList" style="font-size: 1em">';
          content += '    <table class="table table-striped">';
          content += '        <thead>';
          content += '        <tr>';
          content += '            <th scope="col">#</th>';
          content += '            <th scope="col">ISBN</th>';
          content += '           <th scope="col">Book Title</th>';
          content += '            <th scope="col">Overdue Fee</th>';
          content += '            <th scope="col">Publisher</th>';
          content += '            <th scope="col">Date Published</th>';
          content += '            <th scope="col">&nbsp;</th>';
          content += '            <th scope="col">&nbsp;</th>';
          content += '        </tr>';
          content += '        </thead>';
          content += '        <tbody>';
          // if(books.length > 0)
          books.forEach(function(book, i) {
            content += `
                  <tr>
                    <th scope="row">${i+1}</th>
                    <td>${book.isbn}</td>
                    <td>${book.title}</td>
                    <td>${book.overdueFee}</td>
                    <td>${book.publisher}</td>
                    <td>${book.datePublished}</td>
                    <td><a href="http://localhost:8080/elibrary/api/book/get/${book.bookId}">Edit</a></td>
                    <td><a href="http://localhost:8080/elibrary/api/book/delete/${book.bookId}">Delete</a></td> 
                    </tr>
                    </tbody>
               `;
          });
          content += '</table>';
          document.getElementById("divMainContainer").innerHTML = content;
      })
      .catch(err => {
        console.log('Error message:', err.statusText);
        document.getElementById("divMainContainer").innerHTML = '<p style="color:#ff0000;">Sorry. The elibrary books data service is unavailable. Pleaase try again later</p>';
      });
    }
    const lnkGetBooks = document.querySelector('#lnkGetBooks');
    lnkGetBooks.addEventListener('click', getBooks);
  })();