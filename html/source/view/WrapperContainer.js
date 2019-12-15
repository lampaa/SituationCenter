/*
 * File: app/view/WrapperContainer.js
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

Ext.define('Cameras.view.WrapperContainer', {
    extend: 'Ext.Container',
    alias: 'widget.wrappercontainer',

    requires: [
        'Cameras.view.CamerasGrid',
        'Cameras.view.EventsList',
        'Cameras.view.Map',
        'Ext.Panel',
        'Ext.grid.Grid'
    ],

    layout: 'hbox',

    items: [
        {
            xtype: 'panel',
            flex: 1,
            title: 'Cameras',
            items: [
                {
                    xtype: 'camerasgrid',
                    height: '100%',
                    itemId: 'grid'
                }
            ]
        },
        {
            xtype: 'panel',
            flex: 1,
            title: 'Events',
            items: [
                {
                    xtype: 'eventslist',
                    height: '100%',
                    itemId: 'eventslist'
                }
            ]
        },
        {
            xtype: 'map',
            itemId: 'map',
            flex: 3
        }
    ]

});