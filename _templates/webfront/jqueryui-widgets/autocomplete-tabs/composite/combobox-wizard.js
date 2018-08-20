function CustomComboboxWizard(options) {
    console.log("CustomComboboxWizard");
    this.domElementId = options && options.id;
    this.dom = document.getElementById(this.domElementId);
    this.$dom = $(this.dom);
}

CustomComboboxWizard.prototype.init = function (options) {
    console.log(this.$dom.find('.autocomplete-tabs-select').attr("id"));

    var wizard = new CustomWizard({id: this.$dom.find('.dropdown-wizard').attr("id")});
    var combobox = new CustomCombobox({id: this.$dom.find('.autocomplete-tabs-select').attr("id")});

    wizard.init();

    combobox.init({
        onFocus: function () {
            console.log("onFocus");
            // $dropdownButton.trigger("click");
        }
    });

}
