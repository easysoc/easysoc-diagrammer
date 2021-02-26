const path = require('path');
const webpack = require('webpack');

module.exports = {
	mode: 'production',
	// mode: 'development',
	// remove this for production mode
	// devtool: 'source-map',
	performance: {
		maxEntrypointSize: 512000,
		maxAssetSize: 512000
	},
	entry: {
		diagrammer: './src/main/ts/diagrammer.ts'
	},

	output: {
		filename: '[name].js',
		path: path.resolve(__dirname, 'src/main/webapp')
	},

	module: {
		rules: [
			{
				test: /\.(ts|tsx)$/,
				use: ['ts-loader'],
        		exclude: /node_modules/
			},
			{
				test: /\.js$/,
				use: ['ts-loader'],
				exclude: /node_modules/
			},
			{
				test: /\.css$/,
				use: ['style-loader', 'css-loader'],
			}
		]
	},

	resolve: {
		extensions: ['.tsx', '.ts', '.js']
	},

	plugins: [new webpack.ProgressPlugin()]
};
