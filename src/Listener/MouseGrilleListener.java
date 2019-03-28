package Listener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.SwingUtilities;

import Affichage.AffichageGrille;
import Source.Case;
import Source.Joueur;

public class MouseGrilleListener implements MouseListener, MouseMotionListener {

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		AffichageGrille ag = (AffichageGrille)e.getSource();
		ag.setPosX(x-(ag.getWidth()/ag.getGrilleB().getTaille()/2)-1);
		ag.setPosY(y-(ag.getHeight()/ag.getGrilleB().getTaille()/2)-1);
		ag.repaint();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (SwingUtilities.isLeftMouseButton(e)) {
			int x = e.getX();
			int y = e.getY();
			AffichageGrille ag = (AffichageGrille)e.getSource();
			Case c = new Case((x/(ag.getWidth()/ag.getGrilleB().getTaille()))+1, (y/((ag.getHeight()/ag.getGrilleB().getTaille())))+1);
			Joueur j = ag.getJoueur();
			if (ag.getBateauPlace() < ag.getJoueur().getTabBateau().size())
			{
				if (j.placerBateau(ag.getBateau(), c, ag.getOrient())) {
					ag.setBateauPlace(ag.getBateauPlace()+1);
				}
				ag.repaint();
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
