# Start guide

### Structure directory
```bash
├── index.html  
├── main.css
└── README.md
```

### Structure modal dialog
```html
├── <button type="button" data-toggle="modal" data-target="#idModal">
└── <div class="modal fade" id="idModal" tabindex="-1" role="dialog">
    └── <div class="modal-dialog" role="document">
        └── <div class="modal-content">
            ├── <div class="modal-header">
            ├── <div class="modal-body">
            └── <div class="modal-footer">
```

* #### button
    * ``` data-toggle="modal"``` -  button to open modal
    * ``` data-target="#idModal"``` - target button, id modal to open
* #### div.modal
    * ``` class="modal"``` - div is modal window
    * ``` class="fade"``` - modal slide down animation
    * ``` id="idModal"``` -  id for calling
    * ``` tabindex="-1"``` - need to close across click on empty area
    * ``` role="dialog"``` - need to better accessibility  
* #### div.modal-dialog
    * ``` role="document"``` - need to better accessibility  
* #### div.modal-content
    Include ```div.modal-header```, ```div.modal-body```, ```div.modal-footer```.
    Can have closing button. Layout button:
    ```html
    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
        <span aria-hidden="true">&times;</span>
    </button>
    ```
