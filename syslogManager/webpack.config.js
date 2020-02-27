config = {
   entry: './main.js',
	output: {
      filename: 'index.js'
   },
   devServer: {
      host: '0.0.0.0',
      inline: true,
      port: 8081
   },
   module: {
      loaders: [
         {
            test: /\.jsx?$/,
            exclude: /node_modules/,
            loader: 'babel-loader',

            query: {
               presets: ['es2015', 'react']
            }
         }
      ]
   }
}
module.exports = config;
