function CustomWizard(options) {
    console.log("CustomWizard " + options.id);
    this.domElementId = options && options.id;
    this.dom = document.getElementById(this.domElementId);
    this.$dom = $(this.dom);
}

CustomWizard.prototype.init = function (options) {

    var $dropdownButton = this.$dom.find("button.dropdown-toggle");
    var $dropdownContent = this.$dom.find(".dropdown-menu");
    var $dropdownSelectedPlan = this.$dom.find(".dropdown-selected-plan");

    var $selectedCarrierDivs = this.$dom.find(".selected-carrier-container");
    $selectedCarrierDivs.hide();

    var $carrierTabHeader = this.$dom.find("a[href='#menu1']");
    var $planTabHeader = this.$dom.find("a[href='#menu2']");
    var $planTabContent = this.$dom.find(".planTabContainer");

    var $selectedPlanSpans = $(".selected-carrier-id");

    $dropdownButton.hide();
    $dropdownSelectedPlan.hide();

    $dropdownButton.on("click", function() {
        if ($dropdownContainer.data("selected-plan-option")) {
            // dropDownSelectedPlan();
            $dropdownSelectedPlan.show();
            // $autocompleteInput.val('');
        } else {
            $dropdownContent.show();
        }
    });


}
