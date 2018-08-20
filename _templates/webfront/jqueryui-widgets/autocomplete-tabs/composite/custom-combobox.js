$( function() {

    $.widget("custom.combobox", {
        _create: function () {
            this.wrapper = $("<span>")
                .addClass("custom-combobox")
                .insertAfter(this.element);

            // this.element.hide();
            this._createAutocomplete();
            // this._createShowAllButton();
        },

        _createAutocomplete: function () {
            var selected = this.element.children(":selected"),
                value = selected.val() ? selected.text() : "";

            this.input = $("<input>")
                .appendTo(this.wrapper)
                .val(value)
                .attr("title", "")
                .addClass("custom-combobox-input ui-widget ui-widget-content ui-state-default ui-corner-left")
                .autocomplete({
                    delay: 0,
                    minLength: 0,
                    source: $.proxy(this, "_source")
                });

            this._on(this.input, {
                autocompleteselect: function (event, ui) {
                    ui.item.option.selected = true;
                    this._trigger("select", event, {
                        item: ui.item.option
                    });
                    //
                    var $this = $(this.input);
                    var $selectOption = $(ui.item.option);
                    var selectedVal = $selectOption.val();
                    var $autoCompleteTabs = $this.closest(".autocomplete-tabs");

                    //define if it is plan or carrier and select that
                    var optionCategory = $selectOption.data("category");
                    if (optionCategory == 'carrier') {
                        var selectedCarrierId = $selectOption.data("carrier-id");
                        $autoCompleteTabs.find(".dropdown-menu #menu1 li[data-carrier-id = '" + selectedCarrierId + "' ]").click();
                        return;
                    } else if (optionCategory == 'auxiliary-option') {
                    } else {//insurance plan
                        var selectedPlanId = $selectOption.val();
                        $autoCompleteTabs.find(".dropdown-menu #menu2 li[data-plan-id = '" + selectedPlanId + "' ]").click();
                    }
                    var $dropDownSelectedPlan = $autoCompleteTabs.find(".dropdown-selected-plan");
                    $dropDownSelectedPlan.hide();
                    //clear selected plan
                },

                autocompletechange: "_removeIfInvalid",
                autocompletesearch: function (event, ui) {
                    var $input = $(this.input);
                    var $container = $input.closest(".autocomplete-tabs");
                    var $dropDownBody = $container.find(".dropdown-menu");
                    if ($container.data("selected-carrier-id")) {
                        var selectedCarrierId = $container.data("selected-carrier-id");
                        var currentInputValue = $input.val();
                        console.log(currentInputValue);
                        $dropDownBody.find(".planTabContainer li.plan-option").each(function () {
                            var $this = $(this);
                            if ($this.text().toLowerCase().includes(currentInputValue.toLowerCase())
                                && $this.data("carrier-id") == selectedCarrierId) {
                                $this.show();
                            } else {
                                $this.hide();
                            }
                        });
                        return;
                    }
                    //different behaviour depending on carrier selected or not

                    $dropDownBody.hide();
                }
            });
        },

        _source: function (request, response) {
            var matcher = new RegExp($.ui.autocomplete.escapeRegex(request.term), "i");
            response(this.element.children("option").map(function () {
                var $this = $(this);
                var $container = $this.closest(".autocomplete-tabs");
                if ($container.data("selected-carrier-id")) {
                    return;
                }
                var text = $(this).text();
                if (this.value && ( !request.term || matcher.test(text) ))
                    return {
                        label: text,
                        value: text,
                        option: this
                    };
            }));
        },

        _removeIfInvalid: function (event, ui) {

            // Selected an item, nothing to do
            if (ui.item) {
                return;
            }

            // Search for a match (case-insensitive)
            var value = this.input.val(),
                valueLowerCase = value.toLowerCase(),
                valid = false;
            this.element.children("option").each(function () {
                if ($(this).text().toLowerCase() === valueLowerCase) {
                    this.selected = valid = true;
                    return false;
                }
            });

            // Found a match, nothing to do
            if (valid) {
                return;
            }

            // Remove invalid value
            this.input
                .val("")
                .attr("title", value + " didn't match any item");
            this.element.val("");
            this.input.autocomplete("instance").term = "";
        },

        _destroy: function () {
            this.wrapper.remove();
            this.element.show();
        }
    });
});

function CustomCombobox(options) {
    console.log("CustomCombobox");
    this.domElementId = options && options.id;
    this.dom = document.getElementById(this.domElementId);
    this.$dom = $(this.dom);
}

CustomCombobox.prototype.init = function (options) {
    console.log("CustomCombobox init");
    this.$dom.combobox();
    this.$inputDom = this.$dom.find(".custom-combobox-input");

    this.$inputDom.on('focus', options.onFocus);
}
