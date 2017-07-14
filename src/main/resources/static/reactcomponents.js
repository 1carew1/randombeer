// This is a very dirty way of getting some form of react going

var Beer = React.createClass({
  render: function() {
    var result = null;
    if(this.props.beer) {
      var beer = this.props.beer;
      var beerUrl = "https://vignette3.wikia.nocookie.net/simpsons/images/f/f7/Duff_Beer.png/revision/latest?cb=20130915031534";
      if(beer.imageUrl) {
        beerUrl = beer.imageUrl;
      }
      result = (
        <div className="container-fluid">
           <div className="col-md-12">
             <div className="col-md-4">
                <div className="jumbotron">
                  <img className="img-responsive text-center" alt="Cinque Terre" width="304" height="236" src={beerUrl}/>
                </div>
             </div>
             <div className="col-md-1">

             </div>
             <div className="col-md-7">
                <div className="jumbotron">
                  <h3>{beer.name}</h3>
                  <p>{beer.description}</p>
                  <p className="pull-right">{beer.breweryLocation}</p>
                </div>
             </div>
           </div>
         </div>
        );
    }
    return result;
  }
});

var Header = React.createClass({
  render: function() {
    return (
      <div className="container">
        <div className="jumbotron">
          <h1>The Random Beer App</h1>
          <button type="button" className="btn btn-warning pull-right" onClick={this.props.obtainRandomBeer}>Show Another Beer</button>
        </div>
      </div>
      );
  }
});

var App = React.createClass({
  obtainRandomBeer: function() {
    var self = this;
    $.ajax({
      url: "/api/v1/beer"
    }).then(function (data) {
        console.log(data);
        self.setState({beer: data});
    });
  },

  getInitialState: function () {
    return {beer: null};
  },

  componentDidMount: function() {
    this.obtainRandomBeer();
  },

  render: function() {
    return (
      <div className="container">
        <Header  obtainRandomBeer={this.obtainRandomBeer}/>
        <Beer beer={this.state.beer} />
      </div>);
  }
});

ReactDOM.render(
  <App />, document.getElementById('root')
);