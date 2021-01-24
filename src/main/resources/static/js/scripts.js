//Prevent reloading with parameters in url
window.history.replaceState({}, document.title, window.location.pathname);

//Handle editing form
const editButtons = document.getElementsByClassName("edit-button");

for (const editButton of editButtons) {
   editButton.addEventListener("click",
    function (event) {
        event.preventDefault();

        if (event.target.classList.contains("submit")) {
            const path = new URL(window.location.href.split('?')[0]);
            const id = event.target.previousElementSibling.value
            const parameters = {
                id,
                author: document.getElementById(`${id}_author`).value,
                title: document.getElementById(`${id}_title`).value,
                isbn: document.getElementById(`${id}_isbn`).value,
                year: document.getElementById(`${id}_year`).value,
                action: "update_book"
            };

            Object.keys(parameters).forEach(key => path.searchParams.append(key, parameters[key]));

            fetch(path.href)
                .then((response) => {
                    if (response.ok) {
                        event.target.classList.remove("submit")
                    }
                });
        } else {
            event.target.classList.add("submit");
        }

        const inputs = event.target.parentElement.parentElement.parentElement.getElementsByTagName("input");

        for (const input of inputs) {
            input.disabled = input.disabled ? false : true;
        }

     }
   )
}
