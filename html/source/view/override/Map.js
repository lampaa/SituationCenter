Ext.define('Cameras.view.override.Map', {
    override: 'Cameras.view.Map',
    
    config: {
        map: null,
        cameras: {},
        react: null
    },
    
    initialize: function() {
        let that = this;
        let e = React.createElement;
        
        this.setReact(ReactDOM.render(e(createReactClass({
            getInitialState: function() {
                return { items: [], center: [55.751574, 37.573856]};
            },
            render: function() {
                let placemarks = [];
                
                console.log(window.ReactYandexMaps);

                for(let i=0; i < this.state.items.length; i++) {
                    let location = this.state.items[i].get("location");

                    placemarks.push(e(window.ReactYandexMaps.Placemark, {
                        geometry: [location.latitude, location.longitude],
                            options: {
                                preset: 'islands#blueCircleDotIconWithCaption',
                                iconCaptionMaxWidth: '50'
                            }
                        }));
                }
        

                let map = e(window.ReactYandexMaps.Map, {
                    state: { center: this.state.center, zoom: 10 },
                    width: '100%',
                    height: '100%'
                }, placemarks);
                
                console.log(map, this.state.center);

                return e(window.ReactYandexMaps.YMaps, null, map);
            }
        })), this.mapContainer.dom));
    },
    
    createMap: function() {
        let map = this.getMap();
        
        if(!map) {
            map = React.createElement(window.ReactYandexMaps.Map, {
                defaultState: { center: [55.751574, 37.573856], zoom: 10 },
                width: '100%',
                height: '100%'
            });
            
            
            this.setMap(map);
        }
    },
    
    getElementConfig: function() {
        return {
            reference: 'element',
            className: 'x-container',
            children: [{
                reference: 'bodyElement',
                style: 'width: 100%; height: 100%',
                className: 'x-inner',
                children: [{
                    style: 'width: 100%; height: 100%',
                    reference: 'mapContainer',
                    className: Ext.baseCSSPrefix + 'map-container'
                }]
            }]
        };
    },
    
    addCamera: function(cameraModel) {    
        if(!this.containsCamera(cameraModel)) {
            this.getCameras()[cameraModel.get("id")] = cameraModel;
            
            this.getReact().setState({
                items: Object.values(this.getCameras())
            });
            
            this.fitCamera(cameraModel);
        }
    },
    
    removeCamera: function(cameraModel) {
        if(this.containsCamera(cameraModel)) {
            delete this.getCameras()[cameraModel.get("id")];
            
            this.getReact().setState({
                items: Object.values(this.getCameras())
            });
        }
    },
    
    fitCamera: function(cameraModel) {
        if(this.containsCamera(cameraModel)) {
            let location = this.getCameras()[cameraModel.get("id")].get("location");
            
            this.getReact().setState({
                center: [location.latitude, location.longitude]
            });
        }
    },
    
    privates: {
        containsCamera: function(cameraModel) {
            cameraId = "" + cameraModel.get("id");
            
            console.log(Object.keys(this.getCameras()).includes(cameraId), Object.keys(this.getCameras()), cameraId);
            return Object.keys(this.getCameras()).includes(cameraId);
        }
    }
});