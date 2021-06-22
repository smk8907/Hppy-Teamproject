var templates = {
    'dropbox': '{{#options}}{{>option}}{{/options}}',
    'option': '<option value="{{value}}"{{#selected}} selected="selected"{{/selected}}>{{text}}</option>'
};

var data = {
    'option': [
        { 'value': '0', 'text': 'USER'},
        { 'value': '1', 'text': 'ADMIN', 'selected':true},
        { 'value': '2', 'text': 'MASTER'}
    ]
};

$('#role').append(Mustache.render(templates.dropbox, data, templates));