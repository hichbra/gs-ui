package org.graphstream.ui.j2dviewer.renderer.test

import org.graphstream.graph._
import org.graphstream.scalags.graph.MultiGraph

import org.graphstream.algorithm.Toolkit._

import org.graphstream.ui.graphicGraph.stylesheet.{Values, StyleConstants}
import org.graphstream.ui.swingViewer.{Viewer, DefaultView, ViewerPipe, ViewerListener}
import org.graphstream.ui.graphicGraph.stylesheet.StyleConstants
import org.graphstream.ui.spriteManager._
import org.graphstream.ui.j2dviewer._

import org.graphstream.ScalaGS._

object TestShapeDecor {
	def main( args:Array[String] ) { (new TestShapeDecor).run } 
}

class TestShapeDecor extends ViewerListener {
	var loop = true
	
	def run() = {
		val graph  = new MultiGraph( "TestSize" )
		val viewer = new Viewer( graph, Viewer.ThreadingModel.GRAPH_IN_ANOTHER_THREAD )
		val pipeIn = viewer.newViewerPipe
		val view   = viewer.addView( "view1", new J2DGraphRenderer )
//		val view   = viewer.addDefaultView( true )
  
		pipeIn.addAttributeSink( graph )
		pipeIn.addViewerListener( this )
		pipeIn.pump

		graph.addAttribute( "ui.stylesheet", styleSheet )
		graph.addAttribute( "ui.antialias" )
		graph.addAttribute( "ui.quality" )
		
		val A:Node = graph.addNode( "A" )
		val B:Node = graph.addNode( "B" )
		val C:Node = graph.addNode( "C" )
		val D:Node = graph.addNode( "D" )
		val E:Node = graph.addNode( "E" )
		val F:Node = graph.addNode( "F" )
		val G:Node = graph.addNode( "G" )
		
		val U:Node = graph.addNode( "U" )
		val V:Node = graph.addNode( "V" )
		val W:Node = graph.addNode( "W" )
		val X:Node = graph.addNode( "X" )
		val Y:Node = graph.addNode( "Y" )
		val Z:Node = graph.addNode( "Z" )
		val T:Node = graph.addNode( "T" )

		graph.addNodes( "a", "b", "c", "d", "e", "f", "g",   "u", "v", "w", "x", "y", "z", "t",   "i", "j" )
		val au:Edge = graph.addEdge( "au", "a", "u" )
		val bv:Edge = graph.addEdge( "bv", "b", "v" )
		val cw:Edge = graph.addEdge( "cw", "c", "w" )
		val dx:Edge = graph.addEdge( "dx", "d", "x" )
		val ey:Edge = graph.addEdge( "ey", "e", "y" )
		val fz:Edge = graph.addEdge( "fz", "f", "z" )
		val gt:Edge = graph.addEdge( "gt", "g", "t" )
		val ij:Edge = graph.addEdge( "ij", "i", "j" )
		
		val AU:Edge = graph.addEdge( "AU", "A", "U" )
		val BV:Edge = graph.addEdge( "BV", "B", "V" )
		val CW:Edge = graph.addEdge( "CW", "C", "W" )
		val DX:Edge = graph.addEdge( "DX", "D", "X" )
		val EY:Edge = graph.addEdge( "EY", "E", "Y" )
		val FZ:Edge = graph.addEdge( "FZ", "F", "Z" )
		val GT:Edge = graph.addEdge( "GT", "G", "T" )
		
		A("xyz") = ( 0, 6, 0 )
		B("xyz") = ( 0, 5, 0 )
		C("xyz") = ( 0, 4, 0 )
		D("xyz") = ( 0, 3, 0 )
		E("xyz") = ( 0, 2, 0 )
		F("xyz") = ( 0, 1, 0 )
		G("xyz") = ( 0, 0, 0 )
		
		U("xyz") = ( 3, 5, 0 )
		V("xyz") = ( 3, 4, 0 )
		W("xyz") = ( 3, 3, 0 )
		X("xyz") = ( 3, 2, 0 )
		Y("xyz") = ( 3, 1, 0 )
		Z("xyz") = ( 3, 0, 0 )
		T("xyz") = ( 3,-1, 0 )
		
		graph.getNode[Node]("a")("xyz") = ( 6, 5, 0 )
		graph.getNode[Node]("b")("xyz") = ( 6, 4, 0 )
		graph.getNode[Node]("c")("xyz") = ( 6, 3, 0 )
		graph.getNode[Node]("d")("xyz") = ( 6, 2, 0 )
		graph.getNode[Node]("e")("xyz") = ( 6, 1, 0 )
		graph.getNode[Node]("f")("xyz") = ( 6, 0, 0 )
		graph.getNode[Node]("g")("xyz") = ( 6,-1, 0 )
		
		graph.getNode[Node]("u")("xyz") = ( 9, 6, 0 )
		graph.getNode[Node]("v")("xyz") = ( 9, 5, 0 )
		graph.getNode[Node]("w")("xyz") = ( 9, 4, 0 )
		graph.getNode[Node]("x")("xyz") = ( 9, 3, 0 )
		graph.getNode[Node]("y")("xyz") = ( 9, 2, 0 )
		graph.getNode[Node]("z")("xyz") = ( 9, 1, 0 )
		graph.getNode[Node]("t")("xyz") = ( 9, 0, 0 )
		
		graph.getNode[Node]("i")("xyz") = ( 3, 7, 0 )
		graph.getNode[Node]("j")("xyz") = ( 6, 8, 0 )
		
		A("label") = "Center"
		B("label") = "AtLeft"
		C("label") = "AtRight"
		D("label") = "Left"
		E("label") = "Right"
		F("label") = "Under"
		G("label") = "Above"
		
		U("label") = "Center"
		V("label") = "AtLeft"
		W("label") = "AtRight"
		X("label") = "Left"
		Y("label") = "Right"
		Z("label") = "Under"
		T("label") = "Above"
		
		au("label") = "Center"
		bv("label") = "AtLeft"
		cw("label") = "AtRight"
		dx("label") = "Left"
		ey("label") = "Right"
		fz("label") = "Under"
		gt("label") = "Above"
		ij("label") = "Along"
			
		while( loop ) {
			pipeIn.pump
			sleep( 40 )
		}
		
		printf( "bye bye" )
		exit
	}
	
	protected def sleep( ms:Long ) { Thread.sleep( ms ) }

// Viewer Listener Interface
 
	def viewClosed( id:String ) { loop = false }
 
 	def buttonPushed( id:String ) {
 		if( id == "quit" )
 			loop = false
 		else if( id == "A" )
 			print( "Button A pushed%n".format() )
 	}
  
 	def buttonReleased( id:String ) {} 
 
// Data
 	
	val styleSheet = """
			graph {
				canvas-color: white;
 				fill-mode: gradient-radial;
 				fill-color: white, #EEEEEE;
 				padding: 60px;
 			} 
			node {
				shape: circle;
				size: 10px;
				fill-mode: plain;
				fill-color: #0004;
			}
			node:clicked {
				fill-color: #F004;
			}
			node:selected {
				fill-color: #00F4;
			}
			node#A {
				text-alignment: center;
				text-color: #F00;
			}
			node#B {
				text-alignment: at-left;
				text-color: #0F0;
			}
			node#C {
				text-alignment: at-right;
				text-color: #00F;
			}
			node#D {
				text-alignment: left;
				text-color: #FF0;
			}
			node#E {
				text-alignment: right;
				text-color: #0FF;
			}
			node#F {
				text-alignment: under;
				text-color: #F0F;
			}
			node#G {
				text-alignment: above;
				text-color: #999;
			}
			node#U {
				text-alignment: center;
				text-color: #F00;
				icon-mode: at-left;
				icon: url('file:///home/antoine/Documents/Perso/Art/Icons/GSLogo11d24.png');
			}
			node#V {
				text-alignment: at-left;
				text-color: #0F0;
				icon-mode: at-left;
				icon: url('file:///home/antoine/Documents/Perso/Art/Icons/GSLogo11d24.png');
			}
			node#W {
				text-alignment: at-right;
				text-color: #00F;
				icon-mode: at-left;
				icon: url('file:///home/antoine/Documents/Perso/Art/Icons/GSLogo11d24.png');
			}
			node#X {
				text-alignment: left;
				text-color: #FF0;
				icon-mode: at-left;
				icon: url('file:///home/antoine/Documents/Perso/Art/Icons/GSLogo11d24.png');
			}
			node#Y {
				text-alignment: right;
				text-color: #0FF;
				icon-mode: at-left;
				icon: url('file:///home/antoine/Documents/Perso/Art/Icons/GSLogo11d24.png');
			}
			node#Z {
				text-alignment: under;
				text-color: #F0F;
				icon-mode: at-left;
				icon: url('file:///home/antoine/Documents/Perso/Art/Icons/GSLogo11d24.png');
			}
			node#K {
				text-alignment: above;
				text-color: #999;
				icon-mode: at-left;
				icon: url('file:///home/antoine/Documents/Perso/Art/Icons/GSLogo11d24.png');
			}
			edge {
				fill-color: #0004;
			}
			edge#au { text-alignment: center; }
			edge#bv { text-alignment: at-left; }
			edge#cw { text-alignment: at-right; }
			edge#dx { text-alignment: left; }
			edge#ey { text-alignment: right; }
			edge#fz { text-alignment: under; }
			edge#gt { text-alignment: above; }
			edge#ij { text-alignment: along; }
			"""
}