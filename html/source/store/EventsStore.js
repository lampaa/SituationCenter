/*
 * File: app/store/EventsStore.js
 *
 * This file was generated by Sencha Architect version 4.2.6.
 * http://www.sencha.com/products/architect/
 *
 * This file requires use of the Ext JS 7.0.x Modern library, under independent license.
 * License of Sencha Architect does not include license for Ext JS 7.0.x Modern. For more
 * details see http://www.sencha.com/license or contact license@sencha.com.
 *
 * This file will be auto-generated each and everytime you save your project.
 *
 * Do NOT hand edit this file.
 */

Ext.define('Cameras.store.EventsStore', {
    extend: 'Ext.data.Store',

    requires: [
        'Cameras.model.EventsModel',
        'Ext.data.proxy.Ajax',
        'Ext.data.reader.Json'
    ],

    constructor: function(cfg) {
        var me = this;
        cfg = cfg || {};
        me.callParent([Ext.apply({
            groupField: 'cameraId',
            storeId: 'EventsStore',
            model: 'Cameras.model.EventsModel',
            proxy: {
                type: 'ajax',
                url: 'http://localhost:8080/events',
                reader: {
                    type: 'json'
                }
            }
        }, cfg)]);
    }
});